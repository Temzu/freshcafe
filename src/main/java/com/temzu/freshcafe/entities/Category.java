package com.temzu.freshcafe.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "image_name")
  private String imageName;

  @Column(name = "active_status")
  private boolean activeStatus;

  @OneToMany(mappedBy = "category")
  private List<Product> products;

  @Column(name = "createdAt")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updatedAt")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

}
