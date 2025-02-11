package arboDeSeda.backend.Presentacion.DTOs.Topico;

import arboDeSeda.backend.Dominio.Topico;

public class TopicoDTOMapper {

    public static Topico convertirTopicoRegistroDTOATopico(TopicoRegistroDTO topicoRegistroDTO){
        return new Topico(topicoRegistroDTO);
    }

}
