package com.spring.henallux.DLivres.dataAccess.entity;

import javax.persistence.*;



    @Entity
    @Table(name="publishinghouse")
    public class PublishingHouseEntity {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name="publishinghouse_id")
        private Integer publishingHouse_id;

        @Column(name="wording")
        private String wording;

        public Integer getPublishingHouse_id()
        {
            return publishingHouse_id;
        }
        public void setPublishingHouse_id(Integer publishingHouse_id)
        {
            this.publishingHouse_id =publishingHouse_id;
        }
        public String getWording()
        {
            return wording;
        }
        public void setWording(String wording)
        {
            this.wording = wording;
        }
    }

