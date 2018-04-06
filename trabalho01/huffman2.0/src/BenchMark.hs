module Main where
import System.IO (readFile, hClose)
import Control.Exception
import System.IO.Error
import Data.Function
import System.Console.ANSI
import Huffman
import File

-- Main menu that let user choose between compressing and decompressing files

import Criterion.Main
main = defaultMain [
  bgroup "encode" [ bench "file1.txt"  $ whnf encode "file1.txt"
               , bench "file2.txt"  $ whnf encode "file2.txt"
               , bench "file3.txt" $ whnf encode "file3.txt"
               ]
  ]

 -- User chooses file to be compressed
encode :: String -> IO ()
encode a = do
            clearScreen
            file <- readFile a
            let list = buildTree (sortingList (elementFrequency file))
            let lettersCode = findLetterCode list ""
            writeCodeInFile file "out" lettersCode (show(list) ++ "\n")
