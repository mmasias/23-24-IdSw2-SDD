package Controllers;

import java.util.ArrayList;

import Models.Elevator;
import Models.Floor;
import Models.Building;

public class Buildings 
{

    private ArrayList<Building> building;
	
    public Buildings()
    {
	building = new ArrayList<Building>();
    }
	
    public static void createBuilding() 
    {
        int amountFloors = InitialValues.getAmountFloors();
        int amountElevators = InitialValues.getAmountElevators();
        int elevatorCapacity = InitialValues.getElevatorCapacity();
        int elevatorFloor = InitialValues.getElevatorFloor();
        String label = InitialValues.getLabel();

        ArrayList<Floor> floors = Floors.createFloors(amountFloors, label);
        ArrayList<Elevator> elevators = Elevators.createElevators(amountElevators, elevatorCapacity, elevatorFloor);
	    
	building.add(new Building(floors, elevators));
    }

    public static Building getBuilding()  
    {
        return building;
    }

    public void update(int index, Building updatedBuilding) 
    {
        if (index >= 0 && index < building.size())
            building.set(index, updatedBuilding);
        else
            System.out.println("Indice fuera de Rango.");
    }

    public void delete(int index)
    {
        if (index >= 0 && index < building.size())
            building.remove(index);
        else
            System.out.println("Indice fuera de Rango");
    }

    public Building getBuildingAtIndex(int index) 
    {
	if (index >= 0 && index < building.size())
            return building.get(index);
    }

    public ArrayList<Building> getBuildings() 
    {
        return buildings;
    }
}
