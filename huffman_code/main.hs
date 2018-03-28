module Start where
import Huffman
import AbstractData
import Heap
import File

start :: ([Char]) -> [HuffmanNode]
start (xs) = let list = preparerHeapify(readingFile,[])
                      in heapifyUp(length(list)-1,list)
