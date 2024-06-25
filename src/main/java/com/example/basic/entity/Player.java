package com.example.basic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "team")
public class Player {
  @Id
  int playerId;
  String playerName;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="team_id")
  @JsonIgnore
  Team team;

}