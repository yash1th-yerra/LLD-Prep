package parkinglot.models;

import parkinglot.enums.GateType;

public abstract class Gate {
    private final String gateId;
    public Gate(String gateId){
        this.gateId = gateId;
    }
    public  abstract GateType getGateType();


}
