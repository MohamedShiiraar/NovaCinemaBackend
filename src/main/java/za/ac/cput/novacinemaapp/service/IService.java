package za.ac.cput.novacinemaapp.service;

public interface IService<T,ID> {
    T create(T t);

    T read(ID id);

    T update(T t);
}
