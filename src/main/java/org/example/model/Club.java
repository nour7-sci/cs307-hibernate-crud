package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "clubs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Club {

  @Id
  private int id;
  @Column(name = "name", length = 30, nullable = false)
  private String name;

  @ToString.Exclude
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "stadium_id", unique = true)
  Stadium stadium;

  @ToString.Exclude
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
  List<Player> players;

  @ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "fans_clubs", joinColumns = @JoinColumn(name = "club_id")
      , inverseJoinColumns = @JoinColumn(name = "fan_id"))
  Set<Fan> fans;
}

// select *
// from clubs
// where id = x;

// select *
// from stadiums
// where club_id = x;

// select


// Table persons
// id, name, age, gender, created_at, updated_at, created_by, updated_by

// Person not entity
// PersonDto map Person

// PersonDao expose PersonDto

// Fetch Type (Eager, Lazy)

// relations, DTO, Fetch (lazy, eager), lombok dependency (boilerplate code)
// Hibernate N+1 query problem