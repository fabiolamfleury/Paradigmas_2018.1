module File where
import Data.Maybe (fromMaybe)

-- Write the compress cod in the file
writeCodeInFile :: String -> String -> [(Char, String)] -> String -> IO ()
writeCodeInFile [] fileOut _ fileCode = do
  writeFile fileOut fileCode
  print "Arquivo comprimido"

writeCodeInFile fileToBeCompressed fileOut lettersCode fileCode = do
  -- lookup get the code of letter in lettersCode
  -- fromMaybe convert Maybe String to String
  let letterCode = fromMaybe "" ((lookup (head fileToBeCompressed) lettersCode))
  writeCodeInFile (tail fileToBeCompressed) fileOut lettersCode (fileCode ++ letterCode)
