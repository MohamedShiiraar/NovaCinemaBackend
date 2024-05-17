package za.ac.cput.novacinemaapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Ticket {
    @Id
    private String ticketID;
    private String title;
    private String description;
    private String assignedTo;
    private String status;

    public Ticket() {
    }

    public Ticket(Builder builder) {
        this.ticketID = builder.ticketID;
        this.title = builder.title;
        this.description = builder.description;
        this.assignedTo = builder.assignedTo;
        this.status = builder.status;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(ticketID, ticket.ticketID) && Objects.equals(title, ticket.title) && Objects.equals(description, ticket.description) && Objects.equals(assignedTo, ticket.assignedTo) && Objects.equals(status, ticket.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, title, description, assignedTo, status);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID='" + ticketID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private String ticketID;
        private String title;
        private String description;
        private String assignedTo;
        private String status;

        public Builder setTicketID(String ticketID) {
            this.ticketID = ticketID;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAssignedTo(String assignedTo) {
            this.assignedTo = assignedTo;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(Ticket ticket) {
            this.ticketID = ticket.ticketID;
            this.title = ticket.title;
            this.description = ticket.description;
            this.assignedTo = ticket.assignedTo;
            this.status = ticket.status;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}

