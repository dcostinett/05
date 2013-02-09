package com.scg.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: dcostinett
 * Date: 1/19/13
 * Time: 11:16 AM
 * <p/>
 * Encapsulates the concept of a billable skill.
 */
@SuppressWarnings({"serial", "unchecked"})
public enum Skill implements Serializable {
    PROJECT_MANAGER("Project Manager") {
        public int getRate() {
            return 250;
        }
    },
    SOFTWARE_ENGINEER("Software Engineer"){
        public int getRate() {
            return 150;
        }
    },
    SOFTWARE_TESTER("Software Tester"){
        public int getRate() {
            return 100;
        }
    },
    SYSTEM_ARCHITECT("System Architect"){
        public int getRate() {
            return 200;
        }
    },
    UNKNOWN_SKILL("UNKNOWN"){
        public int getRate() {
            return 0;
        }
    };

    private final String value;

    private Skill(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public int getRate() {
        return this.getRate();
    }
}
