package com.example.geneLabs.utils;

import android.text.InputFilter
import android.text.Spanned

class SearchInputFilter() : InputFilter {
    override fun filter(
        source: CharSequence, start: Int, end: Int, dest: Spanned,
        dstart: Int, dend: Int
    ): CharSequence? {
        for (i in start until end) {
            if (i > 1) {//starting check if the length is equal to 3
                if ((source[i] == source[i - 1]) and (source[i] == source[i - 2])) {
                    return dest
                }
            }
        }

        return null
    }
}