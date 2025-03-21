package seedu.address.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.assignment.Assignment;
import seedu.address.model.assignment.UniqueAssignmentList;
import seedu.address.model.tag.Tag;

/**
 * Represents a Student in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Address address;
    private final Subject subject;

    // Data fields
    private final Set<Tag> tags = new HashSet<>();
    private final UniqueAssignmentList assignments;

    /**
     * Constructing a basic Student object with only the identity fields, such as name, phone, email,
     * address and subject.
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param subject
     */
    public Student(Name name, Phone phone, Email email, Address address, Subject subject) {
        requireAllNonNull(name, phone, email, address, subject);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.subject = subject;
        this.assignments = new UniqueAssignmentList();
    }

    /**
     * Every field must be present and not null.
     * Additional constructor for student to include subject, tags and assignments.
     */
    public Student(Name name, Phone phone, Email email, Address address, Subject subject,
                   Set<Tag> tags,
                   UniqueAssignmentList assignments) {
        requireAllNonNull(name, phone, email, address, subject, tags, assignments);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.subject = subject;
        this.tags.addAll(tags);
        this.assignments = assignments;
    }



    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Subject getSubject() {
        return subject;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public UniqueAssignmentList getAssignments() {
        return assignments;
    }

    /**
     * Returns a new student with the assignment added.
     */
    public Student addAssignment(Assignment assignment) {
        requireNonNull(assignment);
        UniqueAssignmentList newAssignments = this.assignments;
        newAssignments.add(assignment);
        return new Student(name, phone, email, address, subject, tags, newAssignments);
    }

    /**
     * Returns true if both students have the same name.
     * This defines a weaker notion of equality between two students.
     */
    public boolean isSameStudent(Student otherStudent) {
        if (otherStudent == this) {
            return true;
        }

        return otherStudent != null
                && otherStudent.getName().equals(getName());
    }

    /**
     * Returns true if both students have the same identity and data fields.
     * This defines a stronger notion of equality between two students.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Student)) {
            return false;
        }

        Student otherStudent = (Student) other;
        return name.equals(otherStudent.name)
                && phone.equals(otherStudent.phone)
                && email.equals(otherStudent.email)
                && subject.equals(otherStudent.subject);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags, assignments);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("tags", tags)
                .add("assignments", assignments)
                .toString();
    }

    public void markAssignment(String assignmentName) {
        assignments.markAssignment(assignmentName);
    }

    public void unmarkAssignment(String assignmentName) {
        assignments.unmarkAssignment(assignmentName);
    }
}
