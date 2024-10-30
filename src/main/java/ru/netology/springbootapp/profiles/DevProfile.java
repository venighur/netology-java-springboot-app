package ru.netology.springbootapp.profiles;

public class DevProfile implements SystemProfile {
    @Override
    public String setProfile() {
        return "Current profile is dev";
    }
}
