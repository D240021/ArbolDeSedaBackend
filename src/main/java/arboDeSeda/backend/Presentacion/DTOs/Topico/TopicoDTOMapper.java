package arboDeSeda.backend.Presentacion.DTOs.Topico;

import arboDeSeda.backend.Dominio.Topico;

import java.util.List;
import java.util.stream.Collectors;

public class TopicoDTOMapper {

    public static Topico convertirTopicoRegistroDTOATopico(TopicoRegistroDTO topicoRegistroDTO){
        return new Topico(topicoRegistroDTO);
    }

    public static List<TopicoLecturaDTO> convertirTopicosATopicosLecturaDTO(List<Topico> topicos){
        return topicos.stream()
                .map(TopicoLecturaDTO::new)
                .collect(Collectors.toList());
    }

}
