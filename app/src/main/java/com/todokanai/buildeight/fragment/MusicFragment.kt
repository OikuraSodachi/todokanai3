    package com.todokanai.buildeight.fragment

    import android.os.Bundle
    import android.util.Log
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.todokanai.buildeight.adapter.MusicRecyclerAdapter
    import com.todokanai.buildeight.MusicTool
    import com.todokanai.buildeight.databinding.FragmentMusicBinding

    class MusicFragment : Fragment() {
        val binding by lazy { FragmentMusicBinding.inflate(layoutInflater) }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
        ): View? {
            val adapter = MusicRecyclerAdapter()
            adapter.musicList.addAll(MusicTool(context).scanMusicList())
            binding.musicRecyclerView.adapter = adapter
            binding.musicRecyclerView.layoutManager = LinearLayoutManager(context)

            binding.swipe.setOnRefreshListener {
                adapter.notifyDataSetChanged()
                binding.swipe.isRefreshing = false          //------swipe 해서 목록 새로고침

                // lister()
                for(a in 1..MusicTool(context).scanMusicList().size) {
                    Log.d("tester", "Title: ${MusicTool(context).scanMusicList()[a-1].title}")
                }
                Log.d("tester","TrackSize:${MusicTool(context).scanMusicList().size}")
            }       // 스캔된 파일 목록에 대한 로그
            return binding.root
        }
    }
    /*
            refresh 했을때 목록이 재생성됨에 주의
            실제 사용할 재생목록 변수는 별도로 생성, 저장해서
            refresh 해도 안전하게 해놓기
     */