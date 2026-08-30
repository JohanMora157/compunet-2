package com.parcial.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.parcial.model.Device;
import com.parcial.repository.IDeviceRepository;

public class DeviceRepositoryImpl implements IDeviceRepository {

    private  List<Device> devices  = new ArrayList<>();
    private int idCounter = 1;

    
    
    @Override
    public void init() {

        devices.add(new Device(idCounter++,"mastor","3123123","caver",60000,10000,2000,4000,"ms"));
                devices.add(new Device(idCounter++,"victor","56334","cardan",30000,1000,2500,4000,"m"));

                        devices.add(new Device(idCounter++,"pelco","7899","anilo",40000,15000,1000,4000,"s"));




    }

    @Override
    public Device saveDevice(Device device) {

        if(device == null){

            return null;
        }else{

            device.setId(idCounter++);
            devices.add(device);
            return device;

        }

    }

    @Override
    public Device searchDevice(int id) {

        for(Device device : devices){

            if(device.getId() == id){

                return device;
            }

        }

        return null;

    }

    @Override
    public List<Device> listAll() {
       return devices;
    }


    
}
