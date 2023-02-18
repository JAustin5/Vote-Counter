package edu.cofc.android.votecounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.cofc.android.votecounter.databinding.ActivityMainBinding


private val donkeyBgColor = Color.rgb(0x33, 0x33, 0xFF)
private val elephantBgColor = Color.rgb(0xE9, 0x1D, 0x0E)
private val defaultBgColor = Color.rgb(0xFF, 0xFF, 0xFF)

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var counterDonkey = 0
    private var counterElephant = 0

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.donkeyButton.setOnClickListener {
            ++counterDonkey
            binding.donkeyCountTextView.text = counterDonkey.toString()
            if (counterDonkey > counterElephant) {
                binding.root.setBackgroundColor(donkeyBgColor)
                binding.donkeyCountTextView.setTextColor(Color.WHITE)
                binding.elephantCountTextView.setTextColor(Color.WHITE)
            }
            else if (counterElephant > counterDonkey) {
                binding.root.setBackgroundColor(elephantBgColor)
                binding.donkeyCountTextView.setTextColor(Color.WHITE)
                binding.elephantCountTextView.setTextColor(Color.WHITE)
            }
            else {
                binding.root.setBackgroundColor(defaultBgColor)
                binding.donkeyCountTextView.setTextColor(Color.BLACK)
                binding.elephantCountTextView.setTextColor(Color.BLACK)
            }
        }

        binding.elephantButton.setOnClickListener {
            ++counterElephant
            binding.elephantCountTextView.text = counterElephant.toString()

            if(counterElephant > counterDonkey) {
                binding.root.setBackgroundColor(elephantBgColor)
                binding.donkeyCountTextView.setTextColor(Color.WHITE)
                binding.elephantCountTextView.setTextColor(Color.WHITE)
            }
            else if (counterDonkey > counterElephant) {
                binding.root.setBackgroundColor(donkeyBgColor)
                binding.donkeyCountTextView.setTextColor(Color.WHITE)
                binding.elephantCountTextView.setTextColor(Color.WHITE)
            }
            else {
                binding.root.setBackgroundColor(defaultBgColor)
                binding.donkeyCountTextView.setTextColor(Color.BLACK)
                binding.elephantCountTextView.setTextColor(Color.BLACK)
            }
        }

        binding.clearButton.setOnClickListener {
            counterDonkey = 0
            counterElephant = 0
            binding.donkeyCountTextView.text = counterDonkey.toString()
            binding.elephantCountTextView.text = counterElephant.toString()
            binding.root.setBackgroundColor(defaultBgColor)
            binding.donkeyCountTextView.setTextColor(Color.BLACK)
            binding.elephantCountTextView.setTextColor(Color.BLACK)
        }
    }

    override fun onSaveInstanceState(outState : Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counterDonkey", counterDonkey)
        outState.putInt("counterElephant", counterElephant)

        outState.putInt("donkeyBgColor", donkeyBgColor)
        outState.putInt("elephantBgColor", elephantBgColor)
        outState.putInt("defaultBgColor", defaultBgColor)
    }
    override fun onRestoreInstanceState(inState: Bundle) {
        super.onRestoreInstanceState(inState)
        counterDonkey = inState.getInt("counterDonkey")
        binding.donkeyCountTextView.text = counterDonkey.toString()
        counterElephant = inState.getInt("counterElephant")
        binding.elephantCountTextView.text = counterElephant.toString()

        if (counterDonkey > counterElephant) {
            binding.root.setBackgroundColor(donkeyBgColor)
            binding.donkeyCountTextView.setTextColor(Color.WHITE)
            binding.elephantCountTextView.setTextColor(Color.WHITE)
        }
        else if (counterElephant > counterDonkey) {
            binding.root.setBackgroundColor(elephantBgColor)
            binding.donkeyCountTextView.setTextColor(Color.WHITE)
            binding.elephantCountTextView.setTextColor(Color.WHITE)
        }
        else {
            binding.root.setBackgroundColor(defaultBgColor)
            binding.donkeyCountTextView.setTextColor(Color.BLACK)
            binding.elephantCountTextView.setTextColor(Color.BLACK)
        }
    }
}