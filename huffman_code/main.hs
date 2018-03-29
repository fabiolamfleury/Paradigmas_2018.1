module Start where
import Huffman
import AbstractData
import Heap

start :: (String) -> [HuffmanNode]
start xs = let list = preparerHeapify(xs,[])
                      in heapifyUp(length(list)-1,list)
