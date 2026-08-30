package com.parcial.service;

import java.util.List;

import com.parcial.model.Device;

public interface IDeviceService {

     Device saveDevice(Device device);

    Device searchDevice(int id);

    List<Device> listAll();
}
