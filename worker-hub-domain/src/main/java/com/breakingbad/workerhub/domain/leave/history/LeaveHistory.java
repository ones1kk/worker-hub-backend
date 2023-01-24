package com.breakingbad.workerhub.domain.leave.history;

import com.breakingbad.workerhub.domain.leave.approval.LeaveApproval;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "leave_history")
public class LeaveHistory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "leave_history_id")
    private Long id;

    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = false)
    private String createBy;

    @CreatedDate
    @Column(name = "create_date_tiem", updatable = false, nullable = false)
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "leave_approval_id")
    private LeaveApproval leaveApproval;

    @PrePersist
    public void prePersist() {
        createAt = LocalDateTime.now();
    }
}
