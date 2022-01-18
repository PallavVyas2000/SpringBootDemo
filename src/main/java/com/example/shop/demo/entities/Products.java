package com.example.shop.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

        @Id
        private long id;
        private String name;
        private String description;

        public Products(long id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
        
        public Products()
        {
            super();
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Products [description=" + description + ", id=" + id + ", name=" + name + "]";
        }
        

}
