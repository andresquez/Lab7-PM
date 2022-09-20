package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.repository.PokemonRepository


class DetailFragment : Fragment() {
    companion object{
        val IDPoke = "pokemonId"
    }
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var pokemonId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{pokemonId = it.getInt(IDPoke)}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonList = PokemonRepository().getPokemonList()
        val poke = pokemonList.find{it.id == pokemonId}
        Picasso.get().load(poke!!.imageUrlFront).into(binding.imageView2)
        Picasso.get().load(poke.imageUrlBack).into(binding.imageView3)
        Picasso.get().load(poke.imageUrlShinnyFront).into(binding.imageView4)
        Picasso.get().load(poke.imageUrlShinnyBack).into(binding.imageView5)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}