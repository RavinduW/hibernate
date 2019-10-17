package com.wdr.entities;

import javax.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String youtubeChannel;
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    private Instructor instructor;

    public InstructorDetail(){}

    public InstructorDetail(String youtubeChannel,String hobby){
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

//    @Override
//    public String toString() {
//        return "InstructorDetail{" +
//                "id=" + id +
//                ", youtubeChannel='" + youtubeChannel + '\'' +
//                ", hobby='" + hobby + '\'' +
//                ", instructor=" + instructor +
//                '}';
//    }

}
