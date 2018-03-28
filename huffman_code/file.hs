module File where
import System.IO
import System.Directory

readingFile :: String
readingFile = do  putStrLn "Digite o nome do arquivo que será lido"
                  fileName <- getLine
                  inh <- openFile fileName ReadMode
                  inpStr <- hGetContents inh
                  return (inpStr)

currentPath :: IO FilePath
currentPath = getCurrentDirectory

writingFile :: String -> IO ()
writingFile content = do
                        putStrLn "Digite o nome do arquivo de saida"
                        fileName <- getLine
                        writeFile fileName content
