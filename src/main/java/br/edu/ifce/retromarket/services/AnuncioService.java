package br.edu.ifce.retromarket.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifce.retromarket.dtos.AnuncioResponseDTO;
import br.edu.ifce.retromarket.dtos.PlataformaResumoDTO;
import br.edu.ifce.retromarket.entities.Anuncio;
import br.edu.ifce.retromarket.entities.Completude;
import br.edu.ifce.retromarket.repositories.AnuncioRepository;
import br.edu.ifce.retromarket.repositories.CompletudeRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.TransactionScoped;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private CompletudeRepository completudeRepository

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired 
    private PlataformaRepository plataformaRepository;

    @Autowired 
    private CategoriaRepository categoriaRepository;

    @Autowired 
    private CondicaoRepository condicaoRepository;

    @Autowired
    private StatusAnuncioRepository statusAnuncioRepository;

    @Autowired 
    private FotoAnuncioRepository fotoAnuncioRepository;
    
    public Page<AnuncioResponseDTO> listarAnuncios(Pageable pageable) {
        Page<Anuncio> anuncios = anuncioRepository.findAll(pageable);

        Page<AnuncioResponseDTO> pageDTO = anuncios.map(this::toAnuncioResponseDTO);

        for (Anuncio anuncio : anuncios) {
         anuncioDTO.add(toAnuncioResponseDTO(anuncio));
      
         return pageDTO;
      
      }

      publicAnuncioDetalhesDTO buscarporId(Long id){
        Optional<Anuncio> anuncio = anuncioRepository.findById(id);
        
        if (anuncio.isEmpty()){
          throw new ResourceNotFoundException("Anúncio não encontrado");
        }

      return toanuncioDTO(anuncio.get());

      }
      @Transactional 
      public AnuncioDetalhesDTO criaAnuncio(AnuncioRequestDTO anuncioDTO){
        Anuncio anuncio = toAnuncioEntity(anuncioDTO);
        Anuncio anuncioCriado = anuncioRepository.save(anuncio);
        
        return toAnuncioDTO(anuncioCriado);{


      @Transactional 
      public AnuncioDetalhesDTO atualizaranuncio(AnuncioRequestDTO anuncioDTO, Long id){    
       Anuncio anuncioPersistido = anuncioRepository.findByid(id)
        .orElsethrow(()  -> new ResourceNotFoundException("Anúncio não encontrado"));

        Anuncio anuncioDados = toAnuncioEntity(anuncioDTO);

        AnuncioPersistido.setTitulo(anuncioDados.getTitulo())
        anuncioPersistido.setDescricao(anuncioDados.getDescricao());
        anuncioPersistido.setPreco(anuncioDados.getPreco());
        anuncioPersistido.setPlataforma(anuncioDados.getPlataforma());
        anuncioPersistido.setCategoria(anuncioDados.getCategoria());
        anuncioPersistido.setCondicao(anuncioDados.getCondicao());
        anuncioPersistido.setCompletude(anuncioDados.getCompletude());
        anuncioPersistido.setLocalizacao(anuncioDados.getLocalizacao());
        anuncioPersistido.setDataAtualizacao(LocalDateTime.now());

        return toAnuncioDTO(anuncioPersistido);

    }



    public Completude criarCompletude(Completude completude) {
    return repository.save(completude);

    public List<Completude> buscarCompletudes() {
        return repository.findAll();
    }

    private AnuncioResponseDTO toanuncioResponseDTO(Anuncio anuncio) {
      AnuncioResponseDTO  AnuncioResponseDTO = new AnuncioResponseDTO();

      anuncioResponseDTO.setId(anuncio.getId());
      anuncioResponseDTO.setTitulo(anuncio.getTitulo());
      anuncioResponseDTO.setPreco(anuncio.getPreco());
      anuncioResponseDTO.setCondiçao(anuncio.getStatus().getDescricao());

      anuncioResponseDTO.SetCondicao(anuncio.getCondicao().getDescricao());
      anuncioResponseDTO.setCompletude(anuncio.getCompletude().getDescricao());
      anuncioResponseDTO.SetStatus(anuncio.getStatus().getDescricao());

      if (!anuncio.getFotos().isEmptympty())
        anuncioResponseDTO.setUrlFotoPrincipal(anuncio.getFotos().getFirst().getUrl());
      }

      anuncioResponseDTO.setPlataforma(new PlataformaResumoDTO(anuncio.getPlataforma().getId(), anuncio.getPlataforma()));
      anuncioResponseDTO.setCategoria(new CategoriaResumoDTO(anuncio.getCategoria().getId(), anuncio.getCategoria()));

      return anuncioResponseDTO;

    
    }

    private AnuncioDetalhesDTO toAnuncioDTO(Anuncio anuncio)
    anuncio.map(a ->{
      AnuncioDetalhesDTO anuncioDTO = new AnuncioDetalhesDTO();

      anuncioDTO.setId(anuncio.getId());
      anuncioDTO.setTitulo(anuncio.getTitulo());
      anuncioDTO.setDescricao(anuncio.getDescricao());
      anuncioDTO.setPreco(anuncio.getPreco());
      anuncioDTO.setLocalizacao(anuncio.getLocalizacao());
      anuncioDTO.setDataPublicacao(anuncio.getDataPublicacao(). tolocalDate());

      anuncio.DTO.setUrlsFotos(anuncio.getFotos().stream().map(fotoanuncio ->fotoanuncio.getUrl().toList()));

      anuncioDTO.setCategoria(new CategoriaResumoDTO(anuncio.getCategoria().getId(), anuncio.getCategoria().getNome()))
      
      anuncioDTO.setPlataforma(new PlataformaDTO(anuncio.getPlataformaDTO().getId(), anuncio.getPlataforma().getNome(), anuncio.getPlataforma().getFabricante(), anuncio.getPlataforma().getGeracao())));

      anuncioDTO.setCondicao(new CondicaoDTO(anuncio.getCodigo().getDescricao()));

      anuncioDTO.setStatusDTO(new StatusDTO(anuncio.getStatus().getCodigo(), anuncio.getStatus().getDescricao()));

      anuncioDTO.setCompletude(new CompletudeDTO(anuncio.getCompletude().getCodigo(), anuncio.getCompletude().getDescricao()));

      return anuncioDTO;
    });
  } 
      private Anuncio toAnuncioEntity(AnuncioRequestDTO anuncioDTO) {
      usuario Usuario = usuarioRepository.
          findById(anuncioDTO.getIdUsuario());    
          .orElseThrow(()-> new ResourceNotFoundException("Usuário não encontrado"));

          Categoria categoria = categoriaRepositor
          .findById(anuncioDTO.getCategoriaId())
          .orElseThrow(()-> new ResourceNotFoundException("Categoria não encontrada"));

          Plataforma plataforma = plataformaRepository
          .findById(anuncioDTO.getPlataformaId())
          .orElseThrow(()-> new ResourceNotFoundException("Plataforma não encontrada"));

          Completude completude = completudeRepository
          .findByCodigo(anuncioDTO.getCodigoCompletude())
          .orElseThrow(()-> new ResourceNotFoundException("Completude não encontrada"));

          Condicao condicao = condicaoRepository
          .findByCodigo(anuncioDTO.getCodigoCondicao())
          .orElseThrow(()-> new ResourceNotFoundException("Condição não encontrada"));

          StatusAnuncio status = statusAnuncioRepository
          .findByCodigo(anuncioDTO.getCodigoStatus())
          .orElseThrow(()-> new ResourceNotFoundException("Status não encontrada"));

          Anuncio anuncio = new Anuncio();

          anuncio.setUsuario(usuario);
          anuncio.setCategoria(categoria);
          anuncio.setPlataforma(plataforma);
          anuncio.setCompletude(completude);
          anuncio.setCondicao(condicao);
          anuncio.setStatus(status);


          anuncio.setTitulo(anuncioDTO.getTitulo());
          anuncio.setDescricao(anuncioDTO.getDescricao());
          anuncio.Localicao(anuncioDTO.getLocalizacao());
          anuncio.setPreco(anuncioDTO.getPreco());

          if (anuncioDTO.getURLFotos() == null)
            return anuncio;  

          List<FotoAnuncio> fotos = new ArrayList<>();
          for (int i = 0; i < anuncioDTO.getUrlfotos().size(); i++) {
            FotoAnuncio foto = new FotoAnuncio();

            foto.setUrl(anuncioDTO.getUrlfotos().get(i));
            foto.setOrdem(i + 1);
            foto.setPrincipal(i == 0);
            foto.set Anuncio(anuncio);
          
            fotos.add(foto);
          }

          anuncio .setFotos(fotos);
          
          return anuncio;

  } 
}