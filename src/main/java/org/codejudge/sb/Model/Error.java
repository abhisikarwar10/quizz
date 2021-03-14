package org.codejudge.sb.Model;

import java.io.Serializable;

public class Error implements Serializable {

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Error{" +
                "status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    private String status;
    private String reason;
}
