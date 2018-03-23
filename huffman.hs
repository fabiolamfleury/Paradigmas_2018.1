module Huffman where

import AbstractData
import Heap

start(i,xs) = heapifyUp(i,xs)
