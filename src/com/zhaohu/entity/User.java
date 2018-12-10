package com.zhaohu.entity;

import com.zhaohu.utils.GlobalConsts.MemberShipTypes;
import java.time.LocalDateTime;
import static com.zhaohu.utils.GlobalConsts.MemberShipTypes.G;

public class User {
    private int userId;
    private String userName;
    private MemberShipTypes memberType = G;
    private LocalDateTime expiredDate = LocalDateTime.now();
    // private


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MemberShipTypes getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberShipTypes memberType) {
        this.memberType = memberType;
    }

    public LocalDateTime getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDateTime expiredDate) {
        this.expiredDate = expiredDate;
    }
}
