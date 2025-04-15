package com.gfg.ricky_morty_recycler_fragments.Home

import androidx.fragment.app.Fragment
import com.gfg.ricky_morty_recycler_fragments.Home.MainActivity

abstract class BaseFragment : Fragment() {
    protected val navController by lazy {
        (activity as MainActivity).navController
    }
}