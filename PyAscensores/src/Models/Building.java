package Models;
import java.util.List;

public class Building 
{
    List<Floor>    _floor;
    List<Elevator> _elevator;
    boolean        _access;
    int            _capacity;
    
    //region Setters
    public void SetCapacity(int capacity)
    {
        _capacity = capacity; 
    }

    public void SetAccess(boolean access)
    {
        _access = access;
    }

    public void SetFloors(List<Floor> floor)
    {
        _floor = floor;
    }

    public void SetElevators(List<Elevator> elevator)
    {
        _elevator = elevator;
    }
    //endregion

    //region Getters
    public int GetCapacity()
    {
        return _capacity;
    }

    public boolean GetAccess()
    {
        return _capacity;
    }

    public List<Floor> GetFloors()
    {
        return _floor;
    }

    public List<Elevator> GetElevators()
    {
        return _elevator;
    }

  
    //endregion
}
