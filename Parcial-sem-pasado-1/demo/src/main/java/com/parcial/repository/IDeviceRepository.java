package com.parcial.repository;

import java.util.List;

import com.parcial.model.Device;

public interface IDeviceRepository {

    void init();

    Device saveDevice(Device device);

    Device searchDevice(int id);

    List<Device> listAll();
}
