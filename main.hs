import AbstractData
import Heap
import Huffman

start :: ([Char],[HuffmanNode]) -> [HuffmanNode]
start(xs,[]) = let list = preparerHeapify(xs,[])
                      in heapifyUp(length(list)-1,list)
