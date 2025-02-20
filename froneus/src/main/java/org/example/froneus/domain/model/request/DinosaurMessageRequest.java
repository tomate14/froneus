package org.example.froneus.domain.model.request;

import java.time.LocalDateTime;

public class DinosaurMessageRequest {

    private Long dinosaurId;
    private String newStatus;
    private LocalDateTime timestamp;

    public DinosaurMessageRequest() {
    }

    public void setDinosaurId(Long dinosaurId) {
        this.dinosaurId = dinosaurId;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getDinosaurId() {
        return dinosaurId;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
