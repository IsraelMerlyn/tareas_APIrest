package tareas_rest.tareas_rest.mapper;

import tareas_rest.tareas_rest.persistence.entity.Task;

public interface IMapper <I, D> {
    public Task map(I in);
}
