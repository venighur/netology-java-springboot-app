package ru.netology.springbootapp.profiles;

public class ProductionProfile implements SystemProfile {
    @Override
    public String setProfile() {
        return "Current profile is production";
    }
}
