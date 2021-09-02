package ua.javabegin.examples.lesson3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ua.javabegin.examples.lesson3.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    private var _binding: FragmentBlank2Binding ? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: BlankFragment2ViewModel
    private lateinit var mCurrentEvent: EventResponseItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialization()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlank2Binding.inflate(layoutInflater, container, false)

        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(BlankFragment2ViewModel::class.java)
        mViewModel.eventItem.observe(this, {
            mCurrentEvent = it.firstObject.responseItem
            mBinding.textView1BlankFragment2.text = mCurrentEvent.name
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}