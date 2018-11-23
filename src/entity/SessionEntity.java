package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "session", schema = "ibm_icbc", catalog = "")
public class SessionEntity {
    private String sessionId;
    private String userId;
    private String sessionToken;

    public SessionEntity(String sessionId, String userId, String sessionToken) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.sessionToken = sessionToken;
    }

    @Id
    @Column(name = "session_id")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "session_token")
    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionEntity that = (SessionEntity) o;
        return Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(sessionToken, that.sessionToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, userId, sessionToken);
    }
}
