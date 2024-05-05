package Lists;

import java.util.ArrayList;

import Models.IModel;

public class ModelList<T extends IModel> {
    private ArrayList<T> modelList;

    public ModelList() {
        this.modelList = new ArrayList<T>();
    }

    public ArrayList<T> index() {
        return this.modelList;
    }

    public T get(int index) {
        for (T model : this.modelList) {
            if (model.getId() == index) {
                return model;
            }
        }
        return null;
    }

    public void add(T model) {
        this.modelList.add(model);
    }

    public void update(int id, T updatedModel) {
        int position = this.getListPosition(id);
        this.modelList.set(position, updatedModel);
    }

    public void delete(int id) {
        int position = this.getListPosition(id);
        this.modelList.remove(position);
    }

    private int getListPosition(int id) {
        for (int i = 0; i < this.modelList.size(); i++) {
            if (this.modelList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
