package gt.uvg.pokelist.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.model.ApiClient
import gt.uvg.pokelist.model.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {
    companion object {
        const val p_ID = "pokemonId"
    }

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var pokemonId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { pokemonId = it.getInt(p_ID) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get().load(imageUrlFront(pokemonId)).into(binding.imageView2)
        Picasso.get().load(imageUrlBack(pokemonId)).into(binding.imageView3)
        Picasso.get().load(imageUrlShinnyFront(pokemonId)).into(binding.imageView4)
        Picasso.get().load(imageUrlShinnyBack(pokemonId)).into(binding.imageView5)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun imageUrlFront(id: Int): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    fun imageUrlBack(id: Int): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/$id.png"

    fun imageUrlShinnyFront(id: Int): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/$id.png"

    fun imageUrlShinnyBack(id: Int): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/$id.png"
}