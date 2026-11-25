package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "fans")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Fan extends Object{

  @Id
  private int id;
  @Column(name = "name", length = 30, nullable = false)
  private String name;
  @Column(name = "nationality", length = 30)
  private String nationality;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "fans")
  Set<Club> clubs;
}
