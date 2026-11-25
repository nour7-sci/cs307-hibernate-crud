package org.example.model;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CollectionIdJavaClass;

@Entity
@Table(name = "players")
public class Player {

  @Id
  private int id;
  @Column(name = "name", length = 30, nullable = false)
  private String name;
  @Column(name = "t_shirt_number", length = 30, check = @CheckConstraint(constraint = "t_shirt_number > 0"))
  private int tShirtNumber;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "club_id")
  Club club;
}
