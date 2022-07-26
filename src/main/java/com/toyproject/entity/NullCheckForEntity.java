package com.toyproject.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public abstract class NullCheckForEntity {

    public static <T> T checkNullSafe(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Invalid value entered for Entity.");
        }
        return obj;
    }
}
