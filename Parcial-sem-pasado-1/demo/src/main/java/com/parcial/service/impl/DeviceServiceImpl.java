package com.parcial.service.impl;

import java.util.List;

import com.parcial.model.Device;
import com.parcial.repository.IDeviceRepository;
import com.parcial.service.IDeviceService;

public class DeviceServiceImpl implements IDeviceService{

    private final IDeviceRepository deviceRepository;

    public DeviceServiceImpl (IDeviceRepository deviceRepository){

        this.deviceRepository = deviceRepository;

    }

    @Override
    public Device saveDevice(Device device) {
        return deviceRepository.saveDevice(device); 
   }

    @Override
    public Device searchDevice(int id) {
        return deviceRepository.searchDevice(id);    
    }

    @Override
    public List<Device> listAll() {
        return deviceRepository.listAll();
    }

    

}