package com.xhx.computer.impl;

import com.xhx.computer.IComputer;

public class Dell implements IComputer {
    @Override
    public String getInputDevice() {
        return "intel";
    }

    @Override
    public String getCpu() {
        return "amd";
    }

    @Override
    public String getOutputDevice() {
        return "sumang";
    }

    @Override
    public String getStory() {
        return "seagete";
    }
}
