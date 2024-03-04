package com.dmdev.javacore.collections.chats.task1.entity;

import java.util.Objects;

public class Chat implements Comparable<Chat> {

    private String name;
    private int numberOfUsers;

    public Chat(String name, int numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return numberOfUsers == chat.numberOfUsers && Objects.equals(name, chat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfUsers);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }

    @Override
    public int compareTo(Chat other) {
        return this.name.compareTo(other.getName());
    }
}
