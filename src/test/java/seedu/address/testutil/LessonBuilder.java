package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.datetimeutil.Date;
import seedu.address.model.datetimeutil.Time;
import seedu.address.model.lesson.Lesson;
import seedu.address.model.student.Name;
import seedu.address.model.subject.Subject;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Lesson objects.
 */
public class LessonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_SUBJECT = "CS2103T";
    public static final String DEFAULT_DATE = "11-08-2025";
    public static final String DEFAULT_TIME = "14:00";

    private Name name;
    private Date date;
    private Time time;
    private Set<Subject> subjects;

    /**
     * Creates a {@code LessonBuilder} with the default details.
     */
    public LessonBuilder() {
        name = new Name(DEFAULT_NAME);
        date = new Date(DEFAULT_DATE);
        time = new Time(DEFAULT_TIME);
        subjects = new HashSet<>();
        subjects.add(new Subject(DEFAULT_SUBJECT));
    }

    /**
     * Initializes the LessonBuilder with the data of {@code lessonToCopy}.
     */
    public LessonBuilder(Lesson lessonToCopy) {
        name = lessonToCopy.getStudentName();
        date = lessonToCopy.getDate();
        time = lessonToCopy.getTime();
        subjects = new HashSet<>(lessonToCopy.getSubjects());
    }

    /**
     * Sets the {@code Name} of the {@code Lesson} that we are building.
     */
    public LessonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Subject} of the {@code Lesson} that we are building.
     */
    public LessonBuilder withSubjects(String ... subjects) {
        this.subjects = SampleDataUtil.getSubjectSet(subjects);
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Lesson} that we are building
     */
    public LessonBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }
    /**
     * Sets the {@code Time} of the {@code Lesson} that we are building
     */
    public LessonBuilder withTime(String time) {
        this.time = new Time(time);
        return this;
    }
    public Lesson build() {
        return new Lesson(subjects, name, date, time);
    }

}
