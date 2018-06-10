package models.fhKufstein;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LvData {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("jg")
    @Expose
    private String jg;
    @SerializedName("group")
    @Expose
    private Long group;
    @SerializedName("courseName")
    @Expose
    private String courseName;
    @SerializedName("lecturer")
    @Expose
    private String lecturer;
    @SerializedName("rpid")
    @Expose
    private Long rpid;
    @SerializedName("lvid")
    @Expose
    private Long lvid;
    @SerializedName("room")
    @Expose
    private String room;
    @SerializedName("info")
    @Expose
    private String info;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Long getRpid() {
        return rpid;
    }

    public void setRpid(Long rpid) {
        this.rpid = rpid;
    }

    public Long getLvid() {
        return lvid;
    }

    public void setLvid(Long lvid) {
        this.lvid = lvid;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
