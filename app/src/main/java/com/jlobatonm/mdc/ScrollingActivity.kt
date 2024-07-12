package com.jlobatonm.mdc

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar
import com.jlobatonm.mdc.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity()
{
    
    private lateinit var binding: ActivityScrollingBinding
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.fab.setOnClickListener {
            if(binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER){
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }else{
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }
        
        binding.bottomAppBar.setNavigationOnClickListener {
            Snackbar.make(binding.root, getString(R.string.message_action_success),Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .show()
        }
        
        binding.content.btnSkip.setOnClickListener {
            binding.content.cdAdd.visibility   = View.GONE
        }
    }
    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu_scrolling,menu)
        return super.onCreateOptionsMenu(menu)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}