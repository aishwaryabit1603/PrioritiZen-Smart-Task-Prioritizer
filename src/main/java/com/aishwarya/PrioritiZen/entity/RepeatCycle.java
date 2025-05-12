package com.aishwarya.PrioritiZen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public enum RepeatCycle{
    NONE, DAILY , WEEKLY, MONTHLY
}