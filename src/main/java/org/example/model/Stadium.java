package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stadiums")
public class Stadium {

  @Id
  private int id;
  @Column(name = "name", length = 30, nullable = false)
  private String name;
  private int capacity;

  @OneToOne(fetch = FetchType.EAGER, mappedBy = "stadium")
  Club club;
}
