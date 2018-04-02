module File where
import Huffman
import Data.Maybe (fromMaybe)

-- Write the compress cod in the file
writeCodeInFile :: String -> String -> [(Char, String)] -> String -> IO ()
writeCodeInFile [] fileNameOut _ fileCode = do
  writeFile fileNameOut fileCode
  print "Arquivo comprimido"

writeCodeInFile fileToBeCompressed fileNameOut lettersCode fileCode = do
  -- lookup get the code of letter in lettersCode
  -- fromMaybe convert Maybe String to String
  let letterCode = fromMaybe "" ((lookup (head fileToBeCompressed) lettersCode))
  writeCodeInFile (tail fileToBeCompressed) fileNameOut lettersCode (fileCode ++ letterCode)


writeTree :: HuffTree -> IO()
writeTree a = writeFile "tree.txt" c
                  where c = show(a)

-- Convert String in file in a HuffTree
parse :: [Char] -> HuffTree
parse a = read a :: HuffTree
